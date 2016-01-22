import {Component} from 'angular2/core';
import {HTTP_PROVIDERS, Http, Response} from 'angular2/http';
import 'rxjs/add/operator/map';

@Component({
    selector: 'my-app',
    template: `
    	<h1>My First Angular 2 App</h1>
    	<div>
        <h1>People</h1>
        <ul>
          <li *ngFor="#person of people">
            {{person.id}}:{{person.name}}
          </li>
        </ul>
      </div>
    `
})
export class AppComponent {

    people: Object[];
    constructor(http: Http) {
        http.get('http://localhost:8080/mod-web/resources/heroes')
            .map((res: Response) => res.json())
            .subscribe((people: Array<Object>) => this.people = people);
    }

}

