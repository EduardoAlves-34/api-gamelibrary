import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import { LibContextProvider } from './context/LibraryContext';

ReactDOM
.createRoot(document.getElementById('root'))
.render(
   <LibContextProvider>
      <App />
   </LibContextProvider>
);

