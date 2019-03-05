import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent implements OnInit {

  

  constructor(private userService:UserService) { }

  ngOnInit() {
  }

  user:User;

  save(name:String,contact:number,place:String):void{

    this.user=new User();
    this.user.name=name;
    this.user.place=place;
    this.user.contact=contact;
    console.log(this.user.contact);
    this.userService.insert(this.user);

  }
 
}
