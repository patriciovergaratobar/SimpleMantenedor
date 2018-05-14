import 'package:angular/angular.dart';
import 'package:mantenedor_ui/app_component.dart';
import 'package:angular_router/angular_router.dart';
import 'package:http/browser_client.dart';
import 'package:http/http.dart';

void main() {
  
  bootstrap(AppComponent, [
    ROUTER_PROVIDERS,// Remove next line in production
    provide(LocationStrategy, useClass: HashLocationStrategy),
    provide(Client, useFactory: () => new BrowserClient(), deps: [])]);
}
