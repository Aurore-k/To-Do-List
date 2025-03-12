import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { provideHttpClient } from '@angular/common/http';
import { TaskService } from './services/task.service';

bootstrapApplication(AppComponent, {
  providers: [
    provideHttpClient(),
    TaskService]
}).catch(err => console.error(err));
