import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminadddoctorComponent } from './adminadddoctor/adminadddoctor.component';
import { AdmindoctorseditComponent } from './admindoctorsedit/admindoctorsedit.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdminlogoutComponent } from './adminlogout/adminlogout.component';
import { AdminselectspecializationComponent } from './adminselectspecialization/adminselectspecialization.component';
import { AdminupdatedoctorComponent } from './adminupdatedoctor/adminupdatedoctor.component';
import { AppointmentbookingComponent } from './appointmentbooking/appointmentbooking.component';
import { AppointmentstatusComponent } from './appointmentstatus/appointmentstatus.component';
import { BookedappointmentsComponent } from './bookedappointments/bookedappointments.component';
import { DepartmentdoctorsComponent } from './departmentdoctors/departmentdoctors.component';
import { DoctorviewComponent } from './doctorview/doctorview.component';
import { FirstpageComponent } from './firstpage/firstpage.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { RegisterComponent } from './register/register.component';
import { SpecializationsComponent } from './specializations/specializations.component';

const routes: Routes = [
  {'path':'register', component:RegisterComponent},
  {'path':'login', component:LoginComponent},
  {'path':'', component:HomepageComponent},
  {'path':'firstpage', component:FirstpageComponent},
  {'path':'specialization', component:SpecializationsComponent},
  {'path': 'doctorsinspecialization', component: DepartmentdoctorsComponent},
  {'path': 'viewdoctordata', component: DoctorviewComponent},
  {'path': 'logout', component: LogoutComponent},
  {'path': 'bookappointment', component: AppointmentbookingComponent},
  {'path': 'appointmentStatus', component: AppointmentstatusComponent},
  {'path': 'bookedappointments', component: BookedappointmentsComponent},
  {'path': 'adminlogin', component: AdminloginComponent},
  {'path': 'adminselectspecialization', component: AdminselectspecializationComponent},
  {'path': 'doctor-edit/:specialization', component: AdmindoctorseditComponent},
  {'path': 'doctor-update/:specialization/:id', component: AdminupdatedoctorComponent},
  {'path': 'add-doctor/:specialization', component: AdminadddoctorComponent},
  {'path': 'adminlogout', component: AdminlogoutComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
