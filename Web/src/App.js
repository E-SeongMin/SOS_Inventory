import './App.css';
import { firestore } from "./firebase"
import { useState, useEffect } from "react"

function App() {
  //set used
  let [inventoryArray, setInventoryArray] = useState([]);

  function getInventory() {
    const inventory = firestore.collection('Inventory');
    inventory.get().then(docs => {
      docs.forEach(doc => {
        if (doc.exists) {
          setInventoryArray(doc.data());
        }
      });

    });
    console.log(inventoryArray);
  }

  useEffect(() => {
    getInventory();
  }, []);


  return (
    <div className="App">

      <table>
        <tr>
          {inventoryArray.map(ele => (
            <td>몰라
          </td>
          ))}
        </tr>
      </table>


    </div>
  );
}





export default App;
