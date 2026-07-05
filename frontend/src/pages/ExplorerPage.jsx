import { useEffect, useState } from "react";
import Sidebar from "../components/Sidebar";
import Toolbar from "../components/Toolbar";
import ExplorerGrid from "../components/ExplorerGrid";
import api from "../services/explorerApi";

function ExplorerPage() {
  const [drives, setDrives] = useState([]);

  const [currentPath, setCurrentPath] = useState("");
  const [breadcrumbItems, setBreadcrumbItems] = useState([]);
  const [files, setFiles] = useState([]);
  const [backStack, setBackStack] = useState([]);
  const [forwardStack, setForwardStack] = useState([]);
  const [searchKeyword, setSearchKeyword] = useState("");
  const [sortType, setSortType] = useState("name");
  const [loading, setLoading] = useState(false);
  const [loadingMessage, setLoadingMessage] = useState("");
  const [showAlgorithmInfo, setShowAlgorithmInfo] = useState(false);

  function buildBreadcrumb(path) {
    const parts = path.split("\\").filter(Boolean);

    const items = [];

    parts.forEach((part, index) => {
      let fullPath;

      if (index === 0) {
        fullPath = part + "\\";
      } else {
        fullPath = parts.slice(0, index + 1).join("\\");
      }

      items.push({
        label: part,

        path: fullPath,
      });
    });

    return items;
  }

  useEffect(() => {
    loadDrives();
  }, []);

  async function loadDrives() {
    try {
      const response = await api.get("/api/drives");

      setDrives(response.data);
    } catch (error) {
      console.error(error);
    }
  }

  const openFolder = async (
    path,
    saveHistory = true,
    sort = sortType,
    message = "Opening folder...",
  ) => {
    try {
      setLoadingMessage(message);
      setLoading(true);

      if (saveHistory && currentPath !== "") {
        setBackStack((prev) => [...prev, currentPath]);
        setForwardStack([]);
      }

      const response = await api.get("/api/folder", {
        params: {
          path,
          sort,
        },
      });

      setFiles(response.data);
      setCurrentPath(path);
      setBreadcrumbItems(buildBreadcrumb(path));
    } catch (err) {
      console.error(err);
    } finally {
      setTimeout(() => {
        setLoading(false);
      }, 300);
    }
  };

  const changeSort = (type) => {
    setSortType(type);

    if (currentPath !== "") {
      openFolder(currentPath, false, type);
    }
  };

  const goBack = () => {
    if (backStack.length === 0) {
      return;
    }

    const previousPath = backStack[backStack.length - 1];

    setBackStack((prev) => prev.slice(0, -1));

    setForwardStack((prev) => [...prev, currentPath]);

    openFolder(previousPath, false);
  };

  const goForward = () => {
    if (forwardStack.length === 0) {
      return;
    }

    const nextPath = forwardStack[forwardStack.length - 1];

    setForwardStack((prev) => prev.slice(0, -1));

    setBackStack((prev) => [...prev, currentPath]);

    openFolder(nextPath, false);
  };

  const goUp = () => {
    if (!currentPath) {
      return;
    }

    // Jika sudah di root drive (misal E:\)
    if (/^[A-Z]:\\?$/i.test(currentPath)) {
      setCurrentPath("");
      setFiles([]);
      setBreadcrumbItems([]);
      return;
    }

    let parent = currentPath.substring(0, currentPath.lastIndexOf("\\"));

    // Pastikan root drive tetap memakai "\"
    if (/^[A-Z]:$/i.test(parent)) {
      parent += "\\";
    }

    openFolder(parent);
  };

  const refreshFolder = () => {
    if (!currentPath) {
      return;
    }

    openFolder(currentPath, false, sortType, "Refreshing...");
  };

  const search = async () => {
    if (searchKeyword.trim() === "") {
      return;
    }

    try {
      setLoadingMessage("Searching files...");
      setLoading(true);

      const response = await api.get("/api/search", {
        params: {
          path: currentPath,
          keyword: searchKeyword,
        },
      });

      if (currentPath === "") {
        setBreadcrumbItems([
          {
            label: "Hasil Pencarian",
            path: "",
          },
        ]);
      } else {
        setBreadcrumbItems(buildBreadcrumb(currentPath));
      }

      setFiles(response.data);
    } catch (err) {
      console.error(err);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="app">
      <div className="content">
        <Sidebar drives={drives} openFolder={openFolder} />

        <ExplorerGrid
          breadcrumbItems={breadcrumbItems}
          files={files}
          openFolder={openFolder}
          goBack={goBack}
          goForward={goForward}
          goUp={goUp}
          refreshFolder={refreshFolder}
          backStack={backStack}
          forwardStack={forwardStack}
          searchKeyword={searchKeyword}
          setSearchKeyword={setSearchKeyword}
          search={search}
          sortType={sortType}
          changeSort={changeSort}
          currentPath={currentPath}
          loading={loading}
          loadingMessage={loadingMessage}
          showAlgorithmInfo={showAlgorithmInfo}
          setShowAlgorithmInfo={setShowAlgorithmInfo}
        />
      </div>
    </div>
  );
}

export default ExplorerPage;
