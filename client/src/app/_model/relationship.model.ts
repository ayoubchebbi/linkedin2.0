export class Relationship {
  constructor(public user_one_id: number,
              public user_two_id: number,
              public status: string,
              public action_user_id: number) {
  }
}
