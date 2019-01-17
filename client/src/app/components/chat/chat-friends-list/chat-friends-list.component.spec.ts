import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChatFriendsListComponent } from './chat-friends-list.component';

describe('ChatFriendsListComponent', () => {
  let component: ChatFriendsListComponent;
  let fixture: ComponentFixture<ChatFriendsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChatFriendsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChatFriendsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
