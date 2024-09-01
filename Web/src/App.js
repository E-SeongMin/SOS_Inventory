import './App.css';
import { firestore } from "./firebase"
import { useState, useEffect } from "react"
import { collection, getDocs } from "firebase/firestore";

function App() {
  //let [inventoryList, setInventoryList] = useState([{ id: '제발', name: '나와라' }]);
  //let inventoryList = [];
  // function getData() {
  //   const data = firestore.collection('Inventory');
  //   data.get().then((docs) => {
  //     docs.forEach(doc => {
  //       if (doc.exists) {
  //         inventoryList = [{ ...inventoryList, ...doc.data() }];
  //         //let copy = [...inventoryList, { id: doc.data().id, name: doc.data().name, remainCnt: doc.data().remainCnt }]
  //         //setInventoryList(copy);
  //         //console.log(inventoryList[0].id);

  //         // setInventoryList([...inventoryList, {
  //         //   id: doc.data().id,
  //         //   name: doc.data().name,
  //         //   remainCnt: doc.data().remainCnt,
  //         // }]);

  //         // let copy = {
  //         //   id: doc.data().id,
  //         //   name: doc.data().name
  //         // }


  //         // let ascendingCopy = copy.sort((a, b) => a.id - b.id);
  //         // setInventoryList([copy, ...inventoryList]);
  //         //console.log(ascendingCopy);
  //         //console.log(copy[0].id);

  //         //setInventoryList([{id : doc.data().id, name: doc.data().name}, ...inventoryList])
  //         // setInventoryList([{ ...inventoryList, ...doc.data() }])

  //         // console.log(inventoryList);
  //       }
  //     })
  //   })
  //   return inventoryList;
  // }

  let [inventoryList, setInventoryList] = useState([]);

  const fetcData = async () => {
    // ... try, catch 생략
    const inventoryCollectionRef = collection(firestore, 'Inventory'); // 참조
    const inventorySnap = await getDocs(inventoryCollectionRef); // 데이터 스냅 받아오기 - 비동기처리
    const data = inventorySnap.docs.map(doc => ({
      ...doc.data(),
      id: doc.id
    }));
    setInventoryList(data);
    //return data;
  }




  useEffect(() => {
    //getData();
    fetcData();
    //console.log(inventoryList);
  }, []);

  return (
    <div className='App'>
        <table>
          <thead>
            <tr>
              <th>아이디</th>
              <th>이름</th>
            </tr>
          </thead>
          <tbody>
            {inventoryList.map(ele => {
              return (
                <tr>
                  <td>{ele.id}</td>
                  <td>{ele.name}</td>
                </tr>
              )
            })}
          </tbody>
        </table>
    </div>
  );
}


export default App;