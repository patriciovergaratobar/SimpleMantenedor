import 'dart:async';

import 'package:angular/angular.dart';
import 'package:angular_components/angular_components.dart';

import 'lista_service.dart';

@Component(
    selector: 'lista-component',
    styleUrls: const ['lista_component.css'],
    templateUrl: 'lista_component.html',
    directives: const [
      CORE_DIRECTIVES,
      materialDirectives,
    ],
    providers: const [ListaService],
)
class ListaComponent implements OnInit {

  var name = 'Angular';

  final ListaService todoListService;

  List<String> items = [];
  String newTodo = '';

  ListaComponent(this.todoListService);

  @override
  Future<Null> ngOnInit() async {
    items = await todoListService.getTodoList();
  }

  void add() {
    items.add(newTodo);
    newTodo = '';
  }

  String remove(int index) => items.removeAt(index);
  void onReorder(ReorderEvent e) =>
      items.insert(e.destIndex, items.removeAt(e.sourceIndex));
}

