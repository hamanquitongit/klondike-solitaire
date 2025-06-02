import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

import GamePage from './pages/GamePage'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div>
        <GamePage />
      </div>
    </>
  )
}

export default App
