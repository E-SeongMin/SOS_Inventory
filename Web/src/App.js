import './App.css';
import { firestore } from "./firebase"
import { useState, useEffect } from "react"
import { collection, getDocs } from "firebase/firestore";

function App() {
  let [inventoryList, setInventoryList] = useState([]);

  const fetcData = async () => {
    // ... try, catch 생략
    const inventoryCollectionRef = collection(firestore, 'Inventory'); // 참조
    const inventorySnap = await getDocs(inventoryCollectionRef);       // 데이터 스냅 받아오기 - 비동기 처리
    const data = inventorySnap.docs.map(doc => ({ ...doc.data() }));

    // sort
    data.sort((a, b) => a.id - b.id);

    setInventoryList(data);
    console.log(inventoryList);
  }

  useEffect(() => {
    fetcData();
  }, []);

  return (
    <div className='App'>
      <h1>SOS Inventory List</h1>
      <table className='table'>
        <thead>
          <tr>
            <th>품번</th>
            <th>품목</th>
            <th>수량</th>
          </tr>
        </thead>
        <tbody>
          {inventoryList.map(ele => {
            return (
              <tr>
                <td>{ele.id}</td>
                <td>{ele.name}</td>
                <td>{ele.remainCnt}</td>
              </tr>
            )
          })}
        </tbody>
      </table>
    </div>
  );
}

export default App;