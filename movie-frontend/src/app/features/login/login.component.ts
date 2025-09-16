import { Component, inject, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../core/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <div class="login-container">
      <div class="login-card">
        <div class="login-header">
          <h1>MovieApp</h1>
          <p>Sign in to your account</p>
        </div>
        <form (ngSubmit)="onSubmit()" #f="ngForm" class="login-form">
          <div class="form-group">
            <label for="username">Username</label>
            <input 
              id="username"
              [(ngModel)]="username" 
              name="username" 
              type="text"
              placeholder="Enter your username"
              required 
            />
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input 
              id="password"
              [(ngModel)]="password" 
              name="password" 
              type="password"
              placeholder="Enter your password"
              required 
            />
          </div>
          <button type="submit" class="login-btn" [disabled]="loading()">
            <span *ngIf="!loading()">Login</span>
            <span *ngIf="loading()">Signing in...</span>
          </button>
          <div class="error-message" *ngIf="error()">
            {{ error() }}
          </div>
        </form>
        <div class="login-footer">
          <p>Demo accounts:</p>
          <p><strong>Admin:</strong> admin / admin</p>
          <p><strong>User:</strong> user / user</p>
        </div>
      </div>
    </div>
  `,
  styles: [`
    .login-container {
      min-height: 100vh;
      display: flex;
      align-items: center;
      justify-content: center;
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      padding: 20px;
    }
    
    .login-card {
      background: rgba(255, 255, 255, 0.1);
      backdrop-filter: blur(10px);
      border: 1px solid rgba(255, 255, 255, 0.2);
      border-radius: 20px;
      padding: 40px;
      width: 100%;
      max-width: 400px;
      box-shadow: 0 8px 32px rgba(0, 0, 0, 0.3);
    }
    
    .login-header {
      text-align: center;
      margin-bottom: 30px;
    }
    
    .login-header h1 {
      color: #fff;
      font-size: 2.5rem;
      font-weight: 700;
      margin: 0 0 10px 0;
      text-shadow: 0 2px 4px rgba(0, 0, 0, 0.3);
    }
    
    .login-header p {
      color: rgba(255, 255, 255, 0.8);
      margin: 0;
      font-size: 1.1rem;
    }
    
    .login-form {
      display: flex;
      flex-direction: column;
      gap: 20px;
    }
    
    .form-group {
      display: flex;
      flex-direction: column;
      gap: 8px;
    }
    
    .form-group label {
      color: #fff;
      font-weight: 500;
      font-size: 0.9rem;
    }
    
    .form-group input {
      background: rgba(255, 255, 255, 0.1);
      border: 1px solid rgba(255, 255, 255, 0.3);
      border-radius: 10px;
      padding: 12px 16px;
      color: #fff;
      font-size: 1rem;
      transition: all 0.3s ease;
    }
    
    .form-group input:focus {
      outline: none;
      border-color: #7c3aed;
      background: rgba(255, 255, 255, 0.15);
      box-shadow: 0 0 0 3px rgba(124, 58, 237, 0.2);
    }
    
    .form-group input::placeholder {
      color: rgba(255, 255, 255, 0.6);
    }
    
    .login-btn {
      background: linear-gradient(135deg, #7c3aed 0%, #6d28d9 100%);
      color: #fff;
      border: none;
      border-radius: 10px;
      padding: 14px;
      font-size: 1.1rem;
      font-weight: 600;
      cursor: pointer;
      transition: all 0.3s ease;
      margin-top: 10px;
    }
    
    .login-btn:hover:not(:disabled) {
      transform: translateY(-2px);
      box-shadow: 0 6px 20px rgba(124, 58, 237, 0.4);
    }
    
    .login-btn:disabled {
      opacity: 0.7;
      cursor: not-allowed;
      transform: none;
    }
    
    .error-message {
      background: rgba(239, 68, 68, 0.2);
      border: 1px solid rgba(239, 68, 68, 0.4);
      color: #fca5a5;
      padding: 12px;
      border-radius: 8px;
      text-align: center;
      font-size: 0.9rem;
    }
    
    .login-footer {
      margin-top: 30px;
      text-align: center;
      color: rgba(255, 255, 255, 0.7);
      font-size: 0.9rem;
    }
    
    .login-footer p {
      margin: 5px 0;
    }
    
    .login-footer strong {
      color: #fff;
    }
  `]
})
export class LoginComponent {
  private readonly auth = inject(AuthService);
  private readonly router = inject(Router);

  username = '';
  password = '';
  loading = signal(false);
  error = signal<string | null>(null);

  onSubmit() {
    this.error.set(null);
    this.loading.set(true);
    this.auth.login(this.username, this.password).subscribe({
      next: (role) => {
        this.loading.set(false);
        if (role === 'ADMIN') this.router.navigate(['/admin/dashboard']);
        else this.router.navigate(['/user/dashboard']);
      },
      error: () => {
        this.loading.set(false);
        this.error.set('Invalid username or password');
      }
    });
  }
}



