import Breadcrumb from "./Breadcrumb";
import ExplorerItem from "./ExplorerItem";
import Toolbar from "./Toolbar";
import StatusBar from "./StatusBar";

function ExplorerGrid({
  breadcrumbItems,
  files,
  openFolder,
  goBack,
  goForward,
  goUp,
  refreshFolder,
  backStack,
  forwardStack,
  searchKeyword,
  setSearchKeyword,
  search,
  sortType,
  changeSort,
  currentPath,
  loading,
  loadingMessage,
  showAlgorithmInfo,
  setShowAlgorithmInfo,
}) {
  return (
    <div className="explorer">
      <Toolbar
        goBack={goBack}
        goForward={goForward}
        goUp={goUp}
        refreshFolder={refreshFolder}
        canGoBack={backStack.length > 0}
        canGoForward={forwardStack.length > 0}
        searchKeyword={searchKeyword}
        setSearchKeyword={setSearchKeyword}
        search={search}
        sortType={sortType}
        changeSort={changeSort}
        showAlgorithmInfo={showAlgorithmInfo}
        setShowAlgorithmInfo={setShowAlgorithmInfo}
      />

      {showAlgorithmInfo && (
        <div
          className="modal-backdrop"
          onClick={() => setShowAlgorithmInfo(false)}
        >
          <div className="modal" onClick={(e) => e.stopPropagation()}>
            <h2>📘 Struktur Data yang Digunakan</h2>

            <h3>🌳 Tree</h3>
            <p>Membangun struktur direktori file dan folder.</p>

            <h3>📚 Queue (BFS)</h3>
            <p>Digunakan untuk pencarian file dan folder.</p>

            <h3>📑 Stack</h3>
            <p>Digunakan pada navigasi Back dan Forward.</p>

            <h3>⚡ Quick Sort</h3>
            <p>
              Digunakan untuk mengurutkan file berdasarkan nama, ukuran, dan
              tanggal.
            </p>

            <button onClick={() => setShowAlgorithmInfo(false)}>Tutup</button>
          </div>
        </div>
      )}

      <Breadcrumb items={breadcrumbItems} openFolder={openFolder} />

      <div className="file-list">
        {loading && (
          <div className="loading-overlay">
            <div className="spinner"></div>
            <p>{loadingMessage}</p>
          </div>
        )}

        {files.length === 0 ? (
          <div className="empty-state">
            <div className="empty-icon">{searchKeyword ? "🔍" : "📂"}</div>

            <h3>
              {searchKeyword ? "Tidak ada hasil pencarian" : "Folder kosong"}
            </h3>

            <p>
              {searchKeyword
                ? "Coba gunakan kata kunci lain."
                : currentPath === ""
                  ? "Pilih salah satu drive di sebelah kiri."
                  : "Belum ada file atau folder di lokasi ini."}
            </p>
          </div>
        ) : (
          files.map((file) => (
            <ExplorerItem key={file.path} file={file} onOpen={openFolder} />
          ))
        )}
      </div>

      <StatusBar files={files} />
    </div>
  );
}

export default ExplorerGrid;
