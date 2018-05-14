import 'dart:async';

import 'package:angular/angular.dart';
import 'package:angular_components/angular_components.dart';
import 'package:angular_router/angular_router.dart';

import 'src/home_component/home_component.dart';
import 'src/lista_component/lista_component.dart';
import 'src/mantenedor_component/mantenedor_component.dart';
import 'src/menu_component/menu_component.dart';

@Component(
    selector: 'app-component',
    styleUrls: const ['app_component.css'],
    templateUrl: 'app_component.html',
    directives: const [materialDirectives, ROUTER_DIRECTIVES, MenuComponent],
    providers: const [materialProviders],)
@RouteConfig(const [
  const Route(path: 'home', name: 'Home', component: HomeComponent),
  const Route(path: '', name: 'Home', component: HomeComponent),
  const Route(path: '**', name: 'Home', component: HomeComponent),
  const Route(path: 'mantenedor', name: 'Mantenedor', component: MantenedorComponent),
  const Route(path: 'lista', name: 'Lista', component: ListaComponent)
])
class AppComponent  {

  var name = 'Angular';
  String titulo = 'Mantenedor UI';


}

