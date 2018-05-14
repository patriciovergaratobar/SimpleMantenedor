import 'dart:async';

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

import '../../mantenedor_component/mantenedor_service.dart';

@Component(
    selector: 'crear-usuario-component',
    styleUrls: const ['crear_usuario_form_component.css'],
    templateUrl: 'crear_usuario_form_component.html',
    directives: const [MaterialButtonComponent,
                       MaterialIconComponent,
                       CORE_DIRECTIVES,
                       MaterialDialogComponent,
                       AutoDismissDirective,
                       AutoFocusDirective,
                       ModalComponent,
                       materialInputDirectives],
    providers: const [MantenedorService],)
class CrearUsuarioFormComponent {

  final MantenedorService servicios;
  String rutNuevo;
  CrearUsuarioFormComponent(this.servicios);
}

