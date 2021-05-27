import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Cargo } from 'src/app/models/cargo';
import { CargoService } from 'src/app/service/cargo.service';

@Component({
  selector: 'app-lista-cargo',
  templateUrl: './lista-cargo.component.html',
  styleUrls: ['./lista-cargo.component.css']
})
export class ListaCargoComponent implements OnInit {

  cargos: Cargo[] = [];
  constructor(private cargoService: CargoService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.listarCargos();
  }

  listarCargos():void{
    this.cargoService.listarCargo().subscribe(
      data => {
        this.cargos = data;
      },
      err => {
        this.toastr.error('Error', err?.mensaje);
      }
    )
  }

  eliminarCargo(id:number): void{
    this.cargoService.eliminarCargo(id).subscribe(
      () => {
        this.toastr.success('Cargo eliminado', 'información');
        this.listarCargos();
      },
      err => {
        this.toastr.error('Error', err?.mensaje);
      }
    )
  }

}
