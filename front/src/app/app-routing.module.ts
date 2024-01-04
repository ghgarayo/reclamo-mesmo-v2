import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'reclamacoes' },
  {
    path: 'reclamacoes',
    loadChildren: () => import('./reclamacoes/reclamacoes.module')
      .then(m => m.ReclamacoesModule)
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
