import { ApplicationConfig, provideBrowserGlobalErrorListeners } from '@angular/core';
import { provideRouter } from '@angular/router';
import Aura from '@primeuix/themes/aura';
import { routes } from './app.routes';
import { providePrimeNG } from 'primeng/config';
import { provideLottieOptions } from 'ngx-lottie';
import player from 'lottie-web';
import { provideAnimations } from '@angular/platform-browser/animations'; 
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { provideHttpClient } from '@angular/common/http';


export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideRouter(routes),
    providePrimeNG({
      theme: {
        preset: Aura,
        options: {
          darkModeSelector: false
        }
      }
    }),

    // 3. Provedor do Lottie (Animação) -> ESTE BLOCO É O QUE RESOLVE SEU ERRO
    provideLottieOptions({
      player: () => player,
    }),

    provideHttpClient()
  ]
};
