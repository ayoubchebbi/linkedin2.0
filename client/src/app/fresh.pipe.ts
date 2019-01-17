import { Pipe, PipeTransform } from '@angular/core';


@Pipe({
  name: 'fresh'
})
export class FreshPipe implements PipeTransform {


  transform(values: any[], args?: string): any {
    if ( !args || !(args.toUpperCase() === 'JAVA' || args.toUpperCase() === 'C' || args.toUpperCase() === 'PYTHON' || args.toUpperCase() === 'J2EE'
      || args.toUpperCase() === 'ANGULAR' || args.toUpperCase() === 'SPRING BOOT') ) { return values; }
    return values.filter((item) => item.hashtag1 === args.toUpperCase());
  }

}
