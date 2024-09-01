import './App.css';
import { firestore } from "./firebase"
import { useState, useEffect } from "react"

function App() {
  //let [inventoryList, setInventoryList] = useState([{ id: '제발', name: '나와라' }]);
  let inventoryList = [];

  function getData() {
    let data = firestore.collection('Inventory');
    data.get().then((docs) => {
      docs.forEach(doc => {
        //console.log(doc.id);
        if (doc.exists) {
          let inventoryList = [{ ...inventoryList, ...doc.data() }];
          //let copy = [...inventoryList, { id: doc.data().id, name: doc.data().name, remainCnt: doc.data().remainCnt }]
          //setInventoryList(copy);
          console.log(inventoryList);

          // setInventoryList([...inventoryList, {
          //   id: doc.data().id,
          //   name: doc.data().name,
          //   remainCnt: doc.data().remainCnt,
          // }]);

          // let copy = {
          //   id: doc.data().id,
          //   name: doc.data().name
          // }


          // let ascendingCopy = copy.sort((a, b) => a.id - b.id);
          // setInventoryList([copy, ...inventoryList]);
          //console.log(ascendingCopy);
          //console.log(copy[0].id);

          //setInventoryList([{id : doc.data().id, name: doc.data().name}, ...inventoryList])
          // setInventoryList([{ ...inventoryList, ...doc.data() }])

          // console.log(inventoryList);
        }
      })
    })
  }

  useEffect(() => {
    getData();
  }, []);

  return (

    <div>
      <div className='App'>
        {
          inventoryList.map(ele => {
            return (
              <p>{ele.id}</p>
            )
          })
        }
      </div>
    </div>
  );
}


export default App;