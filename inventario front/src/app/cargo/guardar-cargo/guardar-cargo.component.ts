import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms'
import { ToastrService } from 'ngx-toastr';
import { Cargo } from 'src/app/models/cargo';
import { CargoService } from 'src/app/service/cargo.service';

@Component({
  selector: 'app-guardar-cargo',
  templateUrl: './guardar-cargo.component.html',
  styleUrls: ['./guardar-cargo.component.css']
})
export class GuardarCargoComponent implements OnInit {

  cargos: Cargo[] = [];


  formularioCargo: FormGroup;

  constructor(private formBuilder: FormBuilder, private cargoService: CargoService, private toastr: ToastrService) {  
  }

  ngOnInit(): void {
    this.formularioCargo = this.formBuilder.group({
      nombre: ['', Validators.required],
     
    });
  }

  guardarCargo() {
    if(this.formularioCargo.valid){
      this.cargoService.crearCargo(this.formularioCargo.value).subscribe(
       ( )=> {
        this.toastr.success('información', 'El cargo se creo exitosamente');
       },
       (error:any)=> {
        this.toastr.error('Error', error?.mensaje); 
       }
      )
    }
    
}


}
