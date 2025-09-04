import { useEffect, useState } from "react";
import api from "../api";

function ProductList() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    api.get("/products").then((res) => setProducts(res.data)).catch (err => console.error(err));
  }, []);

  return (
    <div>
      <h2>Products</h2>
      <ul>
        {products.map((p) => (
          <li key={p.id}>
            <strong>{p.productName}</strong> <br />
            Description: {p.description} <br />
            Price: ${p.price} <br />
            Category: {p.categoryId}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ProductList;
