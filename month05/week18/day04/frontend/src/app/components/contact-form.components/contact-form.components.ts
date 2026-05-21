// contact-form.component.ts
import { Component } from '@angular/core';

interface ContactForm {
  name: string;
  email: string;
  subject: string;
  message: string;
  priority: string;
  subscribe: boolean;
}

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent {
  formData: ContactForm = {
    name: '',
    email: '',
    subject: '',
    message: '',
    priority: 'normal',
    subscribe: false
  };

  priorities = ['low', 'normal', 'high', 'urgent'];
  submitted = false;
  submittedData: ContactForm | null = null;

  onSubmit(): void {
    this.submittedData = { ...this.formData };
    this.submitted = true;
  }

  resetForm(): void {
    this.formData = {
      name: '',
      email: '',
      subject: '',
      message: '',
      priority: 'normal',
      subscribe: false
    };
    this.submittedData = null;
    this.submitted = false;
  }

  isFormValid(): boolean {
    const requiredFields: (keyof ContactForm)[] = ['name', 'email', 'message'];

    for (let i = 0; i < requiredFields.length; i++) {
      const fieldName = requiredFields[i];
      const fieldValue = this.formData[fieldName];

      if (typeof fieldValue === 'string' && fieldValue.trim() === '') {
        return false;
      }
    }

    return true;
  }
}