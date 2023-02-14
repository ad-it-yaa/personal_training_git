import React from "react";
import './Admin.css'
import Admin_Content from "./Admin_Content/Admin_Content";
import Admin_Menu from "./Admin_Menu/Admin_Menu";

export default function Admin() {
  return (
    <div className="dashboard_container">
    <div className="dashboard_menu"><Admin_Menu/></div>
    <div className="dashboard_content"><Admin_Content/></div>
    </div>
  );
}
