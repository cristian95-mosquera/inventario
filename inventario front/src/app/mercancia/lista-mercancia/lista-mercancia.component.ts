import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Mercancia } from 'src/app/models/mercancia';
import { MercanciaService } from 'src/app/service/mercancia.service';

@Component({
  selector: 'app-lista-mercancia',
  templateUrl: './lista-mercancia.component.html',
  styleUrls: ['./lista-mercancia.component.css']
})

export class ListaMercanciaComponent implements OnInit {

  mercancia: Mercancia[] = [];
  buscarTexto: string;


  constructor(private mercanciaService: MercanciaService, private toastr: ToastrService) { }

  ngOnInit() {
    this.cargarLista();
  
  }

  cargarLista(): void{
    this.mercanciaService.listar().subscribe(
      data => {
        this.mercancia = data;
      },
      err => {
        console.log(err);
      }
    ) 
  }

  eliminarMercancia(id:number): void{
    this.mercanciaService.eliminar(id).subscribe(
      () => {
        this.toastr.success('Mercancia eliminada', 'información');
        this.cargarLista();
      },
      err => {
        this.toastr.error(err.error?.mensaje,'Error');
      }
    )
  }

  buscarPalabra(buscarTexto:string): void{
    this.mercanciaService.consultarPorNombre(buscarTexto).subscribe(
      data => {
        this.toastr.success(buscarTexto, 'información');
      },
      err => {
        this.toastr.error(err.error?.mensaje,'Error');
      }

    )
  }

  
}


