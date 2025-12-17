import React, { useState } from 'react'
import Footer from './components/Footer'
import Login from './components/Login'
import Dashboard from './components/Dashboard'
import { Routes, Route, Navigate } from 'react-router-dom'
import "./styles/App.css"


function LayoutSinNavbar({ children }) {
  return <>{children}</>;
}

function App() {
  const [isLogged, setIsLogged] = useState(false);
  const [user, setUser] = useState(null);

  return (
    <div>

      <Routes>
        <Route path="/" element={<Navigate to="/login" />} />
        <Route path='/login' element={<Login setIsLogged={setIsLogged} setUser={setUser} />} />
        <Route path="/dashboard/*" element={isLogged ? (
          <LayoutSinNavbar><Dashboard user={user} /></LayoutSinNavbar>) : (
          <Navigate to="/login" state={{ aviso: "Debe iniciar sesión" }} />)} />
      </Routes>
      <Footer />
    </div>
  )

}

export default App

