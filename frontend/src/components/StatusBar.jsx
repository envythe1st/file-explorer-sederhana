function StatusBar({ files }) {
  const folderCount = files.filter((f) => f.directory).length;

  const fileCount = files.filter((f) => !f.directory).length;

  return (
    <div className="status-bar">
      {folderCount} Folder • {fileCount} File
    </div>
  );
}

export default StatusBar;
