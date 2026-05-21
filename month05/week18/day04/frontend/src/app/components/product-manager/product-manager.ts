// product-manager.component.ts
import { Component } from '@angular/core';

interface Product {
  id: number;
  name: string;
  price: number;
  category: string;
  inStock: boolean;
}

@Component({
  selector: 'app-product-manager',
  templateUrl: './product-manager.component.html',
  styleUrls: ['./product-manager.component.css']
})
export class ProductManagerComponent {
  products: Product[] = [
    { id: 1, name: 'Laptop', price: 999, category: 'Electronics', inStock: true },
    { id: 2, name: 'T-Shirt', price: 25, category: 'Clothing', inStock: true },
    { id: 3, name: 'Coffee Maker', price: 79, category: 'Kitchen', inStock: false },
    { id: 4, name: 'Running Shoes', price: 129, category: 'Sports', inStock: true },
  ];

  categories = ['All', 'Electronics', 'Clothing', 'Kitchen', 'Sports'];
  selectedCategory = 'All';
  searchQuery = '';
  inStockOnly = false;

  get filteredProducts(): Product[] {
    // TODO: your code here — filter by selectedCategory, searchQuery, inStockOnly
    return this.products;
  }

  get totalValue(): number {
    // TODO: your code here — sum price of filteredProducts
    return 0;
  }
}
