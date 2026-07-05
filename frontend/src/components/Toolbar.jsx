import {
  ArrowLeft,
  ArrowRight,
  ArrowUp,
  RefreshCw,
  Search,
  Info,
} from "lucide-react";

function Toolbar({
  goBack,
  goForward,
  goUp,
  refreshFolder,

  canGoBack,
  canGoForward,

  searchKeyword,
  setSearchKeyword,
  search,
  sortType,
  changeSort,
  showAlgorithmInfo,
  setShowAlgorithmInfo,
}) {
  return (
    <div className="toolbar">
      <div className="toolbar-left">
        <button disabled={!canGoBack} onClick={goBack}>
          <ArrowLeft size={18} />
        </button>

        <button disabled={!canGoForward} onClick={goForward}>
          <ArrowRight size={18} />
        </button>

        <button onClick={goUp}>
          <ArrowUp size={18} />
        </button>

        <button onClick={refreshFolder}>
          <RefreshCw size={18} />
        </button>
      </div>

      <div className="toolbar-search">
        <select value={sortType} onChange={(e) => changeSort(e.target.value)}>
          <option value="folder">Folder Dulu</option>
          <option value="name">Nama (A-Z)</option>
          <option value="name-desc">Nama (Z-A)</option>
          <option value="size">Ukuran</option>
          <option value="date">Tanggal</option>
        </select>
        <Search size={18} />

        <input
          type="text"
          placeholder="Cari file atau folder..."
          value={searchKeyword}
          onChange={(e) => setSearchKeyword(e.target.value)}
          onKeyDown={(e) => {
            if (e.key === "Enter") {
              search();
            }
          }}
        />
      </div>
      <button onClick={() => setShowAlgorithmInfo(true)} title="Info Algoritma">
        <Info size={18} />
      </button>
    </div>
  );
}

export default Toolbar;
