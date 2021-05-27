import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GuardarCargoComponent } from './cargo/guardar-cargo/guardar-cargo.component';
import { ListaCargoComponent } from './cargo/lista-cargo/lista-cargo.component';
import { EditarMercanciaComponent } from './mercancia/editar-mercancia/editar-mercancia.component';
import { ListaMercanciaComponent } from './mercancia/lista-mercancia/lista-mercancia.component';
import { NuevoMercanciaComponent } from './mercancia/nuevo-mercancia/nuevo-mercancia.component';
import { GuardarUsuarioComponent } from './usuario/guardar-usuario/guardar-usuario.component';
import { ListaUsuarioComponent } from './usuario/lista-usuario/lista-usuario.component';


const routes: Routes = [
{path: 'listar', component:ListaMercanciaComponent},
{path: 'nuevoMercancia', component:NuevoMercanciaComponent},
{path: 'editar/:id', component:EditarMercanciaComponent},
{path: 'registrarUsuario', component:GuardarUsuarioComponent},
{path: 'crearCargo', component:GuardarCargoComponent},
{path: 'verUsuario', component:ListaUsuarioComponent},
{path: 'listaCargos', component:ListaCargoComponent},
{path: '**', redirectTo: 'listar', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }