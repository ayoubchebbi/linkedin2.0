export class Chat {
  constructor(public chat_id: number,
              public user_from_id: number,
              public user_to_id: number,
              public message: string,
              public send_on: Date) {
  }
}
