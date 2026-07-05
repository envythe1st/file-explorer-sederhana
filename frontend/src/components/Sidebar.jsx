import { FaHardDrive } from "react-icons/fa6";

function Sidebar({ drives, openFolder }) {
  return (
    <div className="sidebar">
      <h3>Drive</h3>

      <br />

      {drives.map((drive) => (
        <div
          key={drive}
          className="drive-item"
          onClick={() => openFolder(drive)}
        >
          <FaHardDrive color="#555" size={18} />

          <span>{drive}</span>
        </div>
      ))}
    </div>
  );
}

export default Sidebar;
