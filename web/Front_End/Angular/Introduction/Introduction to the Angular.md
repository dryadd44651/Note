# Introduction to the Angular

## What is Angular?

Angular is a front-end development platform, built on TypeScript that **helps build interactive and dynamic single page applications (SPAs)**. 

### Comparison

|                  | Angular          | React                         | Vue                |
| ---------------- | ---------------- | ----------------------------- | ------------------ |
| Learning Curve   | Steep            | Gradual                       | Smooth             |
| Model            | MVVM             | Virtual DOM                   | Virtual DOM        |
| When to Use      | Scalable app     | Cross-Platform (native react) | Lightweight app    |
| Code Style       | Code Consistency | Code flexibility              | Simple integration |
| Team Size Prefer | Large            | Medium                        | Small              |

*Virtual DOM: UI is kept in memory and synced with the “real” DOM by a library*



### Why choosing Angular

1. Supported by Google 
   1. Google’s Long-Term Support (LTS) for Angular means Google is scaling up the project and that the project is going further with time. 
   2. Another important point to mention is that a lot of Google projects are using Angular.
2. TypeScript
   1. TypeScript is a superset of JavaScript which primarily provides optional static typing, classes and interfaces.
   2. TypeScript, which is an Object-Oriented Programming language, it simplifies JavaScript code and makes it easier to read and debug.
   3. ![typscript es6](https://assets-us-01.kc-usercontent.com/cd2c9d9c-6b63-0048-541b-bba1de97e253/8bd7ab74-91fb-4168-90d9-1b20796a3f36/es6-300x300.png)
3. Simplified MVC Pattern MVVM
   1. Its framework uses the MVVM(Model-View-ViewModel) architecture better than an MVC (Model-View-Controller) one. The MVVM model supports two-way data binding between View and ViewModel. This allows the automatic propagation to change within ViewModel’s state to the view.
   
   2. Good for separation of development 
   
   3. Model: Injectable Service (TS file)
   
   4. View: HTML File
   
   5. ViewModel: Component (TS file)
   
      ![img](https://mytechnetknowhows.files.wordpress.com/2014/09/slide11.png)
4. Code Consistency
   1. Angular CLI tool enables the Angular developers to create initial projects, perform tests and integrate diverse features in the same project while keeping the entire team on the same page.
   2. Strong official document: https://angular.io/. Can find most of guidance and sample in `angular.io`
   3. Benefits of code consistency
      1. Reusable
      3. Simplified Unit-Testing
      4. Ease of Maintenance
      5. Efficient development

## Angular Structure

Angular consists of modular which contains component, service, external module

*Every Angular application has at least one class with a @NgModule decorator, it is the root module, conventionally named as AppModule.*

### Overview

**MVVM**

1. Model: Injector provides data to Component
2. View: Template shows the page to User
3. ViewModel: Component is Binding(mapping) the function(Event), variable(Property) to Template and process the data.
   1. Data Binding (How Template communicate with component)
   2. ![Angular Data Binding](https://www.ngdevelop.tech/wp-content/uploads/2017/12/Databinding-300x179.png)



###  Service, Component, Template

![Angular Architecture](https://www.ngdevelop.tech/wp-content/uploads/2017/12/Angular_Architecture.png)

### Module

<img src="https://www.intertech.com/wp-content/uploads/2018/04/modules.jpg" alt="img" style="zoom:80%;" />

### Component

Template is a tree like structure as you can see below

![Template Tree](https://www.ngdevelop.tech/wp-content/uploads/2017/12/TemplateTree-1024x626.png)

## Getting Started

### Set up

```sh
# Install nodejs and npm
sudo apt install nodejs
sudo apt install npm
# Install the Angular CLI
npm install -g @angular/cli
# create Application
ng new ngApp
```

### Application Run

```shell
ng serve --open
```

![Welcome to my-app!](https://angular.io/generated/images/guide/setup-local/app-works.png)

```shell
# generate basic component com
ng generate component com
# remove the default content show above
clean the app.compoent.html and add <app-com></app-com>

```



### Angular configuration

`angular.json` is the file which has various properties and configuration of your Angular project.

Inside the `angular.json` file of this project, under the **architect/build** section, you can see the **options** object as follows

```json
     "architect": {
        "build": {
          "builder": "@angular-devkit/build-angular:browser",
          "options": {
            "outputPath": "dist/ngApp",
            "index": "src/index.html",
            "main": "src/main.ts",
            "polyfills": "src/polyfills.ts",
            "tsConfig": "tsconfig.app.json",
            "assets": [
              "src/favicon.ico",
              "src/assets"
            ],
            "styles": [
              "src/styles.css"
            ],
            "scripts": []
          },
       }
     }
......
```

The "index" and "main" in "options" will defined the root page and application entry point

`Index.html` is the **single page which was provided by the server.**

`main.ts` This **file acts as the entry point of the application**



### Start from root

`index.html` -> `<app-root>`

where is app-root come from

![image-20210825134218843](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210825134218843.png)

App-root in `main.ts`->`AppModule`->`app.module`

![image-20210825134251701](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210825134251701.png)

`app.module.ts`->`AppComponent`->`app.componet.ts`

`Com Component` can be found here too

<img src="https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210825134337228.png" alt="image-20210825134337228" style="zoom:80%;" />

`app.componet.ts`->`component`->`selector`->`app-root`->`app.compoent.html`

Found `app-root`

`app.compoent.html` will be assigned to `app-root` and display in `index.html <app-root> tag`

![image-20210825134438216](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210825134438216.png)y

Add `App work!`

Add `<app-com>`

![image-20210825134504392](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210825134504392.png)

Check and other component created by `ng generate component com`

![image-20210825134451423](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210825134451423.png)

Add `com works!`

![image-20210825134514545](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210825134514545.png)

`index.html` show `app-root` 

- App work!
- `<app-com>`
  - `app-com` show com works!



![image-20210825134528753](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210825134528753.png)

### Data binding

`src\app\com\com.component.ts`

```js
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-com',
  templateUrl: './com.component.html',
  styleUrls: ['./com.component.css']
})
export class ComComponent implements OnInit {
  a=1
  constructor() { }

  ngOnInit(): void {
  }
  add() {
   this.a+=1
   console.log(this.a)
  }
}

```

`src\app\com\com.component.html`

```html
<p>com works!</p>
<p>{{a}}</p>
<button (click)="add()">add</button>
```

![image-20210825160447433](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210825160447433.png)

### Directives

Directives are classes that add additional behavior to elements in your Angular applications. With Angular's built-in directives, you can manage forms, lists, styles, and what users see.

1. [Components](https://angular.io/guide/component-overview)—directives with a template. This type of directive is the most common directive type.
2. [Attribute directives](https://angular.io/guide/built-in-directives#built-in-attribute-directives)—directives that change the appearance or behavior of an element, component, or another directive.
3. [Structural directives](https://angular.io/guide/built-in-directives#built-in-structural-directives)—directives that change the DOM layout by adding and removing DOM elements.
   - NgIf, Ngfor, NgForOf, and NgSwitch

**Components**: Already introduced

**Attribute directives**: change appearance (like CSS)

Ex: add a hover highlight

`ng generate directive highlight`

`src\app\highlight.directive.ts`

```js
import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {

  constructor(private el: ElementRef) { }

  @HostListener('mouseenter') onMouseEnter() {
    this.highlight('yellow');
  }

  @HostListener('mouseleave') onMouseLeave() {
    this.highlight('');
  }

  private highlight(color: string) {
    this.el.nativeElement.style.backgroundColor = color;
  }

}
```

`src\app\app.component.html`

```html
<p>app work!</p>
<app-com></app-com>


<p appHighlight>Highlight me!</p>

<router-outlet></router-outlet>

```

Result

![image-20210825185120281](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210825185120281.png)

**Structural directives**: operate DOM (like JavaScript)

ex:

in Component

```js
  items = [1,2,3,4]
```

in Template

```html
<div *ngFor="let item of items">{{item}}</div>
```

Page

![image-20210825161759301](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210825161759301.png)

### Service

Dependency injection, or DI, is a design pattern in which a class requests dependencies from external sources rather than creating them.

Usually, the Model (MVVM) will be implement in service.

(Ex: Create Rest API to access Database)

**Creating an injectable service**

```sh
ng generate service heroes/hero
```

`src\app\heroes\hero.service.ts`

```js
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
```

`src\app\com\com.component.ts`

*inject the service in the constructor*

*remember set the providers for Component*

```js
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

```

Result

![image-20210825165528664](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210825165528664.png)



## Source

- https://scotch.io/tutorials/mvc-in-an-angular-world#toc-the-viewmodel
- https://www.ngdevelop.tech/angular/architecture/
- https://angular.io/
- https://medium.com/siam-vit/how-an-angular-app-work-behind-the-scenes-angular-flow-dcc4d1df27bd

