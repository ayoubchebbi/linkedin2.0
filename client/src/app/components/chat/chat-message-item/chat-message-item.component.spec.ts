import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChatMessageItemComponent } from './chat-message-item.component';

describe('ChatMessageItemComponent', () => {
  let component: ChatMessageItemComponent;
  let fixture: ComponentFixture<ChatMessageItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChatMessageItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChatMessageItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
