function Breadcrumb({
  items,

  openFolder,
}) {
  if (items.length === 0) {
    return <div className="breadcrumb">Pilih Drive</div>;
  }

  return (
    <div className="breadcrumb">
      {items.map((item, index) => (
        <span key={item.path}>
          <span
            className="breadcrumb-item"
            onClick={() => openFolder(item.path)}
          >
            {item.label}
          </span>

          {index < items.length - 1 && " > "}
        </span>
      ))}
    </div>
  );
}

export default Breadcrumb;
