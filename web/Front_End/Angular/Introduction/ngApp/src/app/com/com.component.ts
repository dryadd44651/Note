import { Component, OnInit } from '@angular/core';
import { HeroService } from '../heroes/hero.service';


@Component({
  selector: 'app-com',
  templateUrl: './com.component.html',
  styleUrls: ['./com.component.css'],
  providers: [HeroService]
})
export class ComComponent implements OnInit {
  
  a=1
  items = [1,2,3,4]
  constructor(private heroService: HeroService) { }

  ngOnInit(): void {
  }
  add() {
   this.a+=1
   console.log(this.a)
   alert(this.heroService.mockAPI_getData())
  }
}
