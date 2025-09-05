import React, { useState } from "react";
import "../LoginModal.css"; // Move the CSS into a separate file
import avatar from "../resources/output_transparent.gif"; // Ensure you have an avatar image
export default function LoginModal() {
  const [isOpen, setIsOpen] = useState(false);

  // Close modal if clicking outside content
  const handleOutsideClick = (e) => {
    if (e.target.className === "modal") {
      setIsOpen(false);
    }
  };

  return (
    <div>
      <h2>Modal Login Form</h2>

      {/* Open modal button */}
      <button onClick={() => setIsOpen(true)} style={{ width: "auto" }}>
        Login
      </button>

      {isOpen && (
        <div className="modal" onClick={handleOutsideClick}>
          <form className="modal-content animate" onSubmit={(e) => e.preventDefault()}>
            <div className="imgcontainer">
              <span
                onClick={() => setIsOpen(false)}
                className="close"
                title="Close Modal"
              >
                &times;
              </span>
              <img src={avatar} alt="Avatar" className="avatar" />
            </div>

            <div className="container">
              <input
                type="text"
                placeholder="Enter Username"
                name="uname"
                required
              />
              <input
                type="password"
                placeholder="Enter Password"
                name="psw"
                required
              />

              <button type="submit">Login</button>
              <label>
                <input type="checkbox" defaultChecked name="remember" /> Remember
                me
              </label>
            </div>

            <div className="container" style={{ backgroundColor: "#f1f1f1" }}>
              <button
                type="button"
                onClick={() => setIsOpen(false)}
                className="cancelbtn"
              >
                Cancel
              </button>
              <span className="psw">
                Forgot <a onClick={() => alert("Password reset flow")}>password?</a>
              </span>
            </div>
          </form>
        </div>
      )}
    </div>
  );
}
