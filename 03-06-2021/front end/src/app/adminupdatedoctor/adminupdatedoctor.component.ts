import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { __param } from 'tslib';
import { Doctors } from '../model/doctors';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-adminupdatedoctor',
  templateUrl: './adminupdatedoctor.component.html',
  styleUrls: ['./adminupdatedoctor.component.css']
})
export class AdminupdatedoctorComponent implements OnInit {

  constructor(private adminService: AdminService, private activatedRouter: ActivatedRoute, private router: Router) { }

  doctor: any;
  updateForm:any;
  id: any;
  ngOnInit(): void {
    // this.adminService.viewDoctorsData()
    this.activatedRouter.paramMap.subscribe(params=>{
      this.id=params.get("id");
      console.log(this.id);  
  });
  this.adminService.viewDoctorsData(+this.id).subscribe(data=> {
      this.doctor=data;
      this.updateForm.patchValue(data);
      console.log(this.doctor);
  });
    this.updateForm=new FormGroup({
      doctorId: new FormControl(null, Validators.required),
      doctorName: new FormControl(null, Validators.required), 
      experience: new FormControl(null, Validators.required), //Note we can add more than one validator, if we have email we can add validator for the email.
      noOfOperationsTaken: new FormControl(null, Validators.required), 
      operationsSuccess: new FormControl(null, Validators.required),
      splName: new FormControl(null, Validators.required),
    });
    
  }

  onSubmit(): void {
    this.adminService.updateDoctor(this.updateForm.value).subscribe(data=> {
      console.log(data);
      this.router.navigate(['doctor-edit/'+this.doctor.splName]);
    })
  }

}
