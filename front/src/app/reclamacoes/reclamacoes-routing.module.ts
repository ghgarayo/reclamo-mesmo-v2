import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReclamacoesComponent } from './reclamacoes/reclamacoes.component';

const routes: Routes = [
  { path: '', component: ReclamacoesComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ReclamacoesRoutingModule { }
