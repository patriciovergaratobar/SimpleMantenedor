import 'dart:async';
import 'dart:convert';

import 'package:angular/angular.dart';
import 'package:http/http.dart';

import 'usuario_model.dart';

@Injectable()
class MantenedorService {

  static final _headers = {'Content-Type': 'application/json'};
  static const _url = 'http://localhost:8080/Mantenedorws/rest/usuario'; 
  final Client _http;

  MantenedorService(this._http);

  Future<List<UsuarioModel>> getList() async {
    try {

      final response = await _http.get('${_url}/getAll');

      final usuarios = _extractData(response)
          .map((value) => new UsuarioModel.fromJson(value))
          .toList();
      
      return usuarios;
    } catch (e) {

      throw _handleError(e);
    }
  }

  Future<bool> crear(UsuarioModel usuario) async {
    try {
      final response = await _http.post('${_url}/crear', headers: _headers, body: JSON.encode(usuario));
      return true;//_extractData(response);
    } catch (e) {
      throw _handleError(e);
    }
  }

  Future<bool> actualizar(UsuarioModel usuario) async {
    try {
      final response = await _http.put('${_url}/editar', headers: _headers, body: JSON.encode(usuario));
      return true;//_extractData(response);
    } catch (e) {
      throw _handleError(e);
    }
  }

  Future<bool> eliminar(UsuarioModel usuario) async {
    try {//debo enviar el id por la url
      final response = await _http.delete('${_url}/eliminar/${usuario.usuarioId}', headers: _headers);
      return true;//_extractData(response);
    } catch (e) {
      throw _handleError(e);
    }
  }

  dynamic _extractData(Response resp) => JSON.decode(resp.body);

  Exception _handleError(dynamic e) {
    print(e); // for demo purposes only
    return new Exception('Server error; cause: $e');
  }
}
