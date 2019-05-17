import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewWalletPageComponent } from './new-wallet-page.component';

describe('NewWalletPageComponent', () => {
  let component: NewWalletPageComponent;
  let fixture: ComponentFixture<NewWalletPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewWalletPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewWalletPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
