//
//  LereleViewController.m
//  Ejemplo2
//
//  Created by macoscar on 05/06/13.
//  Copyright (c) 2013 Universitat Oberta de Catalunya. All rights reserved.
//

#import "EventViewController.h"
#import <EventKit/EventKit.h>

@interface EventViewController () {
//    EKEventStore *store;
}

@end

@implementation EventViewController

- (void)loadView
{
    [super loadView];
    
    self.identifier.text    = [[NSString alloc] initWithFormat:@"id evento: %@", self.evento.identifier];
    self.summary.text       = self.evento.summary;
    self.url.text           = self.evento.url;
    self.start.text         = self.evento.start;
    self.end.text           = self.evento.end;
    
}

- (void)viewDidLoad
{
    [super viewDidLoad];

//    store = [[EKEventStore alloc] init];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (NSDate *)parserDate:(NSString *)dateString
{
    //NSString *date = [[NSDate date] description];
    [NSDateFormatter setDefaultFormatterBehavior:NSDateFormatterBehavior10_4];
    NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
    [dateFormatter setDateFormat:@"yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSSz"];
    
    NSDate *dateFromString = [[NSDate alloc] init];
    dateFromString = [dateFormatter dateFromString:dateString];
    
    
//    NSDateFormatter *formatoSalida = [[NSDateFormatter alloc] init];
//    [formatoSalida setTimeStyle:NSDateFormatterLongStyle];
//    [formatoSalida setDateStyle:NSDateFormatterLongStyle];
//    NSString *date = [formatoSalida stringFromDate:dateFromString];
//    NSLog(@"Fecha (parserDate) = %@", date);
    
    return dateFromString;
    //NSCalendar *calendar = [NSCalendar currentCalendar];
    //NSDateComponents *components = [calendar components:(NSHourCalendarUnit | NSMinuteCalendarUnit) fromDate:date];
    
    //NSLog(@"Summary = %i", components.hour);
}

- (IBAction)crearEvento {
//    NSDateFormatter *formatoSalida = [[NSDateFormatter alloc] init];
//    [formatoSalida setTimeStyle:NSDateFormatterLongStyle];
//    [formatoSalida setDateStyle:NSDateFormatterLongStyle];
//    NSString *date = [formatoSalida stringFromDate:[self parserDate:self.evento.start]];
//    
//    NSLog(@"Fecha (crearEvento) = %@", date);
    EKEventStore *store = [[EKEventStore alloc] init];
    
    [store requestAccessToEntityType:EKEntityTypeEvent completion:^(BOOL granted, NSError *error){
    
        if (!granted) {
            dispatch_async(dispatch_get_main_queue(), ^{
                [[[UIAlertView alloc] initWithTitle:@"Error" message:@"Acceso denegado" delegate:self cancelButtonTitle:@"Ok" otherButtonTitles:nil] show];
            });
        } else {
            EKEvent *event = [EKEvent eventWithEventStore:store];
            
            //Configuramos la informacion basica del evento que vamos a crear
            event.calendar = [store defaultCalendarForNewEvents];
            
            event.title = self.evento.summary;
            event.startDate = [self parserDate:self.evento.start];
            event.endDate = [self parserDate:self.evento.end];
            
            if([store saveEvent:event span:EKSpanThisEvent commit:YES error:nil] == YES){
                dispatch_async(dispatch_get_main_queue(), ^{
                    [[[UIAlertView alloc] initWithTitle:@"Guardado" message:@"Se ha guardado correctamente el evento en su agenda" delegate:self cancelButtonTitle:@"Ok" otherButtonTitles:nil] show];
                });
            } else {
                dispatch_async(dispatch_get_main_queue(), ^{
                    [[[UIAlertView alloc] initWithTitle:@"Error" message:@"Se ha producido un error guardando el evento en el calendario" delegate:self cancelButtonTitle:@"Ok" otherButtonTitles:nil] show];
                });
            }
        }
    }];
}
@end
