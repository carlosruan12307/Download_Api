import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from 'react';
import { Buffer } from "buffer";
function App() {
  const [teste,setteste] = useState([]);

  useEffect(()=>{
console.log(teste)
  },[teste])

  useEffect(() =>{
fetch("http://localhost:8080/",{
  method: "get",
  headers: {
    "Content-Type" : "application/json"
  }
}).then(res => res.json())
.then(res => Object.keys(res).map((e) => new Blob([Buffer.from(res[e],'base64')])))
.then(resblob => setteste(() => resblob))
  },[])
  return (
    // pegando a imagem full dinamicamente pela api
    <div className="App">
      {teste? teste.map((e) => {
        return (<img src={URL.createObjectURL(e)}></img> )
      }) : ""}
   
    </div>

// ............................................................................................................

    // pegando imagem pelo diretorio estatico direto ->  no caso preciso do nome da imagem :( )
    // <div>
    //   <img src='http://localhost:8080/download.png'></img>
    //   <img src='http://localhost:8080/bla.png'></img>
    //   <img src='http://localhost:8080/download1.png'></img>
    // </div>


 
  );
}

export default App;
