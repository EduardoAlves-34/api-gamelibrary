import { createContext, useState } from 'react';
//Criando Contexto
export const LibContext = createContext();
//Criando Provider

export const LibContextProvider = ({children}) => {
    const [Lib, setLib] = useState(null);

    return (
     <LibContext.Provider value={{Lib,setLib}}>
        {children}
     </LibContext.Provider>
);
}