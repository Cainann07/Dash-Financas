import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  private apiUrl = 'http://localhost:8080/usuarios';

  constructor(private http: HttpClient) { }

  cadastrarUsuario(usuario: any): Observable<any> {
    return this.http.post(`${this.apiUrl}`, usuario);
  }

  login(dadosLogin: any): Observable<any> {
    // Atenção: O endpoint é /usuarios/login se o seu controller tiver @RequestMapping("/usuarios")
    return this.http.post(`${this.apiUrl}/login`, dadosLogin);
  }
}
