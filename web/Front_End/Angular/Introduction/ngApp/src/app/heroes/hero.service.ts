import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HeroService {
  // usually we call Rest API in service
  counter=0
  constructor() { }
  mockAPI_getData(){
    this.counter++
    return `data from service: ${this.counter}`
  }
}
