import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontAnalisis';
  port: String = "6500";
  hostName: String = "localhost";
  url: String = "http://"+this.hostName+":"+this.port+"/";

}
