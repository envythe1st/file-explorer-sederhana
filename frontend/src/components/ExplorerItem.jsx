import {
  FaFolder,
  FaRegFileAlt,
  FaFilePdf,
  FaFileWord,
  FaFileExcel,
  FaFilePowerpoint,
  FaFileArchive,
  FaFileImage,
  FaFileAudio,
  FaFileVideo,
  FaFileCode,
} from "react-icons/fa";

function getFileIcon(file) {
  if (file.directory) {
    return <FaFolder color="#f4b400" size={22} />;
  }

  const extension = file.name.split(".").pop().toLowerCase();

  switch (extension) {
    case "pdf":
      return <FaFilePdf color="#e53935" size={20} />;

    case "doc":
    case "docx":
      return <FaFileWord color="#1976d2" size={20} />;

    case "xls":
    case "xlsx":
      return <FaFileExcel color="#2e7d32" size={20} />;

    case "ppt":
    case "pptx":
      return <FaFilePowerpoint color="#ef6c00" size={20} />;

    case "zip":
    case "rar":
    case "7z":
      return <FaFileArchive color="#795548" size={20} />;

    case "png":
    case "jpg":
    case "jpeg":
    case "gif":
    case "webp":
      return <FaFileImage color="#8e24aa" size={20} />;

    case "mp3":
    case "wav":
      return <FaFileAudio color="#00acc1" size={20} />;

    case "mp4":
    case "avi":
    case "mkv":
      return <FaFileVideo color="#d81b60" size={20} />;

    case "java":
    case "js":
    case "jsx":
    case "ts":
    case "tsx":
    case "html":
    case "css":
    case "xml":
    case "json":
      return <FaFileCode color="#fb8c00" size={20} />;

    default:
      return <FaRegFileAlt color="#64748b" size={20} />;
  }
}

function getFileType(file) {
  if (file.directory) return "Folder";

  const ext = file.name.split(".").pop().toLowerCase();

  switch (ext) {
    case "pdf":
      return "PDF Document";

    case "doc":
    case "docx":
      return "Word Document";

    case "xls":
    case "xlsx":
      return "Excel Spreadsheet";

    case "ppt":
    case "pptx":
      return "PowerPoint";

    case "java":
      return "Java Source File";

    case "js":
    case "jsx":
      return "JavaScript File";

    case "png":
    case "jpg":
    case "jpeg":
      return "Image";

    case "zip":
    case "rar":
    case "7z":
      return "Compressed Archive";

    case "mp3":
      return "Audio";

    case "mp4":
      return "Video";

    default:
      return "File";
  }
}

function ExplorerItem({ file, onOpen }) {
  return (
    <div
      className="file-item"
      onClick={() => {
        if (file.directory) {
          onOpen(file.path);
        }
      }}
    >
      <div className="file-icon">{getFileIcon(file)}</div>

      <div className="file-info">
        <div className="file-name">{file.name}</div>

        <div className="file-type">{getFileType(file)}</div>
      </div>
    </div>
  );
}

export default ExplorerItem;
