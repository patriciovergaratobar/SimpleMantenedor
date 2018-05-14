import 'dart:async';
import 'dart:convert';

import 'package:angular/angular.dart';
import 'package:angular_components/material_button/material_button.dart';
import 'package:angular_components/material_icon/material_icon.dart';

import 'package:angular_components/auto_dismiss/auto_dismiss.dart';
import 'package:angular_components/focus/focus.dart';
import 'package:angular_components/laminate/components/modal/modal.dart';
import 'package:angular_components/laminate/overlay/module.dart';
import 'package:angular_components/material_button/material_button.dart';
import 'package:angular_components/material_dialog/material_dialog.dart';
import 'package:angular_components/material_tooltip/material_tooltip.dart';

import 'package:angular_components/material_input/material_input.dart';

import 'usuario_model.dart';
import 'mantenedor_service.dart';

import '../form_component/crear_usuario/crear_usuario_form_component.dart';

import 'package:http/http.dart' as http;

@Component(
    selector: 'mantenedor-component',
    styleUrls: const ['mantenedor_component.css'],
    templateUrl: 'mantenedor_component.html',
    directives: const [MaterialButtonComponent,
                       MaterialIconComponent,
                       CORE_DIRECTIVES,
                       MaterialDialogComponent,
                       AutoDismissDirective,
                       AutoFocusDirective,
                       ModalComponent,
                       materialInputDirectives,
                       CrearUsuarioFormComponent],
    providers: const [MantenedorService],)
class MantenedorComponent implements OnInit  {

  final MantenedorService servicios;
  //final CrearUsuarioFormComponent crearUsuarioFormComponent;
  //Crear usuario
  String rutNuevo;
  String nombreNuevo;
  String correoNuevo;
  String claveNuevo;
  String fechaNuevo;

  //Gestionar Usuario
  UsuarioModel gestionUsuarioModel = new UsuarioModel(0, '', '', '', '', '');

  bool showCrearForm = false;
  bool showEditForm = false;
  bool showDeleteForm = false;

  List<UsuarioModel> lista;

  MantenedorComponent(this.servicios);

  ngOnInit() => _getList();

  _getList() async {
    try {

      lista = await servicios.getList();
      print(lista); //console.log
    } catch (e) {

      print(e.toString()); //console.log
    }
  }

  abrirCrearUsuario() {

    rutNuevo = '';
    nombreNuevo = '';
    correoNuevo = '';
    claveNuevo = '';
    fechaNuevo = '';

    showCrearForm=true;
  }

  crearUsuario() async {
  
    UsuarioModel usuarioNuevo = new UsuarioModel(0, rutNuevo, nombreNuevo, correoNuevo, claveNuevo, fechaNuevo);
    print(usuarioNuevo);
    bool resultado = await servicios.crear(usuarioNuevo);

    print(resultado);
    showCrearForm=false;

    _getList();
  }

  abrirEditarUsuario(UsuarioModel usuario) {

    print('Editar usuario');
    print(usuario);
    gestionUsuarioModel = usuario;
    showEditForm = true;

  }

  editarUsuario() async {
  
    
    print(gestionUsuarioModel);
    bool resultado = await servicios.actualizar(gestionUsuarioModel);

    print(resultado);
    showEditForm=false;

    _getList();
  }

  abrirEliminarUsuario(UsuarioModel usuario) {

    print('Eliminar usuario');
    print(usuario);
    gestionUsuarioModel = usuario;
    showDeleteForm = true;

  }

  eliminarUsuario() async {

    print(gestionUsuarioModel);
    bool resultado = await servicios.eliminar(gestionUsuarioModel);

    print(resultado);
    showDeleteForm = false;

    _getList();
  }

}
