import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LabsecService } from 'src/app/service/labsec.service';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private labsecService: LabsecService, private fb: FormBuilder, private toastr: ToastrService) {

    this.form = this.fb.group({
      inputNumber: ['', [Validators.required, Validators.pattern("^[0-9]*$")]]

    })
  }

  ngOnInit(): void {
  }
  form: FormGroup = new FormGroup({});
  inputNumber: any;
  labseqGeneratedData: any;


  submit() {
    let data = this.form.value;
    console.log('Input number:', data.inputNumber);
    this.labsecService.labseqLoad(data.inputNumber).subscribe(data => {
      this.labseqGeneratedData = data['data'];
      this.form.reset();
      this.toastr.success("Loaded with success", "Success");
    }, (error) => {
      console.log(error);
      this.labseqGeneratedData = error['error']['message'];
      this.toastr.error("Operation not allowed", "Error");
    });

  }

}
