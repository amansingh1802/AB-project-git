import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  baseUrl="http://localhost:8080/myproject";

  constructor(private http:HttpClient) { }
}
